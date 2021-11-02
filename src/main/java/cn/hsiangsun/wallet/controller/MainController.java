package cn.hsiangsun.wallet.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.SSLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hsiangsun.wallet.entity.NotifyBody;
import cn.hsiangsun.wallet.rpc.wallet.AddressGrpc;
import cn.hsiangsun.wallet.rpc.wallet.AddressRequest;
import cn.hsiangsun.wallet.rpc.wallet.AddressResponse;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;

@RestController
public class MainController {
	
	//远程连接管理器,管理连接的生命周期
    private ManagedChannel channel;
    private AddressGrpc.AddressBlockingStub blockingStub;
    
    private AtomicInteger count = new AtomicInteger(0);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/hello")
	public String sayHello() throws InterruptedException {
		
		//load TLS
		File rpcCaFile = null;
		try {
			rpcCaFile = ResourceUtils.getFile("classpath:rpc_client.crt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		SslContext sslcontxt = null;
		try {
			sslcontxt = GrpcSslContexts.forClient().trustManager(rpcCaFile).build();
		}catch(SSLException e) {
			e.printStackTrace();
		}
		
		
		//connection with tls 
		//please replace www.hsiangsun.cn
		channel = NettyChannelBuilder.forAddress("www.abet.life",7777).sslContext(sslcontxt).build();
		
		//connection without tls
//        channel = ManagedChannelBuilder.forAddress("localhost", 7777)
//                .usePlaintext()
//                .build();
		
        //init Stub
        blockingStub = AddressGrpc.newBlockingStub(channel);
        //set rpc request params
        AddressRequest request = AddressRequest.newBuilder().setUid("10010").setSecret("87MREX2PJVHZD6PAJ7PODKK5").build();
        //call rpc method
        AddressResponse response = blockingStub.generateAddress(request);
        //response result
        var address = response.getAddress();
        
        //关闭连接
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        
        return address;
	}
	
	
	
	@PostMapping("/notify")
	public ResponseEntity<Map<String,String>> notify(@RequestBody NotifyBody notify){
		
		System.out.println(notify);
		
		String sql = "insert into recall (value,hash) values (?,?)";
        jdbcTemplate.update(sql, notify.getValue(),notify.getUid());
		
		var value = notify.getValue();
		count.getAndIncrement();
		var body = Map.of("status","ok");
		System.out.println("count = "+count);
		
		if(count.get() == 200) {
			System.exit(0);
		}
		
		
//		if(count.) {
//			body = Map.of("status","err");
//		}
		
		return ResponseEntity.ok(body);
	}
	
}
