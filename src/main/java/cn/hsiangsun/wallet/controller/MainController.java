package cn.hsiangsun.wallet.controller;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hsiangsun.wallet.rpc.wallet.AddressGrpc;
import cn.hsiangsun.wallet.rpc.wallet.AddressRequest;
import cn.hsiangsun.wallet.rpc.wallet.AddressResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2SecurityUtil;
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig;
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolNames;
import io.grpc.netty.shaded.io.netty.handler.ssl.OpenSsl;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider;
import io.grpc.netty.shaded.io.netty.handler.ssl.SupportedCipherSuiteFilter;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;

@RestController
public class MainController {
	
	//远程连接管理器,管理连接的生命周期
    private ManagedChannel channel;
    private AddressGrpc.AddressBlockingStub blockingStub;
	
	@GetMapping("/hello")
	public String sayHello() throws InterruptedException {

		//load tls
		File serverCaFile = new File("cert/server.pem");
		SslContext sslcontxt = null;
		try {
			sslcontxt = GrpcSslContexts.forClient().trustManager(serverCaFile).build();
		}catch(SSLException e) {
			e.printStackTrace();
		}
		
		
		//connection with tls 
		//please replace www.hsiangsun.cn
		channel = NettyChannelBuilder.forAddress("www.hsiangsun.cn",7777).sslContext(sslcontxt).build();
		
		//connection without tls
//        channel = ManagedChannelBuilder.forAddress("localhost", 7777)
//                .usePlaintext()
//                .build();
		
        //init Stub
        blockingStub = AddressGrpc.newBlockingStub(channel);
        //set rpc request params
        AddressRequest request = AddressRequest.newBuilder().setUid("10010").build();
        //call rpc method
        AddressResponse response = blockingStub.generateAddress(request);
        //response result
        var address = response.getAddress();
        
        //关闭连接
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        
        return address;
	}
	
}
