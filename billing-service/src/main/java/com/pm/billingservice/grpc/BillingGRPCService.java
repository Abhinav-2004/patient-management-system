package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGRPCService extends BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGRPCService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseObserver){
        log.info("CreateBillingAccount() request received \n{}", billingRequest.toString());
        //Business Logic From Here

        //Business Logic ends
        BillingResponse response=BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();
        responseObserver.onNext(response);//you can send many responses as you want. REST-> Single response
        responseObserver.onCompleted();

    }

}
