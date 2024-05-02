package org.example;

import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodCreateParams;

public class Main {
    public static void main(String[] args) {
        // Set your secret key. Remember to switch to your live secret key in production.
        // See your keys here: https://dashboard.stripe.com/apikeys
        Stripe.apiKey = "{SECRET_KEY}";

        //Crear customer user

//        CustomerCreateParams params = CustomerCreateParams.builder()
//                .setName( "Pepe Flores" )
//                .setEmail("pepeflores@gmail.com")
//                .build();
//        try {
//            Customer customer = Customer.create(params);
//
//            System.out.println( "Resp OK: " + customer );
//
//        } catch (Exception ex) {
//            System.out.println( "Error al crear customer: " + ex.getMessage());
//        }
        // Customer ID: cus_Q1wjJABW9ZPdTu

// ============================================================================================================

        //Crear un intento de pago con parametros

//        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
//                .setAmount(1500L)
//                .setCurrency("eur")
//                .setCustomer("cus_Q1wjJABW9ZPdTu")
//                .setDescription("Descripción dentro de la generacion de pago autoconfirmado")
//                .build();
//        try {
//
//            PaymentIntent paymentIntent = PaymentIntent.create( params );
//
//            System.out.println("Resp OK:");
//            System.out.println(paymentIntent);
//
//        } catch (Exception ex ) {
//            System.out.println("Error: "+ ex.getMessage() );
//        }

        // PaymentIntent ID: pi_3PBt4dRpYL4S8tgE0vHhNSDK

// ============================================================================================================

        //Crear Payment Method

//        PaymentMethodCreateParams params =
//                PaymentMethodCreateParams.builder()
//                        .setType(PaymentMethodCreateParams.Type.CARD)
//                        .setCard(
//                                PaymentMethodCreateParams.CardDetails.builder()
//                                        .setNumber("4242424242424242")
//                                        .setExpMonth(8L)
//                                        .setExpYear(2026L)
//                                        .setCvc("314")
//                                        .build()
//                        )
//                        .build();
//
//        try {
//            PaymentMethod paymentMethod = PaymentMethod.create(params);
//
//        } catch (Exception ex ) {
//            System.out.println("Error" + ex.getMessage() );
//        }

// ============================================================================================================

        //Crear un intento de pago con parametros con autoconfirmado

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(1800L)
                .setCurrency("eur")
                //.setCustomer("cus_Q1wjJABW9ZPdTu")  // ID DE CUSTOMER
                .setConfirm(true) //Autoconfirmar el mismo Payment
                .setPaymentMethod("pm_card_visa")  //Tarjeta demo de tipo de pago.
                .setAutomaticPaymentMethods(
                PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                        .setEnabled(true)
                        .setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER)
                        .build()
                )
                .setDescription("Descripción dentro de la generacion de pago autoconfirmado")
                .build();
        try {

            PaymentIntent paymentIntent = PaymentIntent.create( params );

            System.out.println("Resp OK:");
            System.out.println(paymentIntent);

        } catch (Exception ex ) {
            System.out.println("Error: "+ ex.getMessage() );
        }


// ============================================================================================================

        //Confirmar Un pago
        
//        PaymentIntent resource = PaymentIntent.retrieve("pi_3MtweELkdIwHu7ix0Dt0gF2H");
//
//        PaymentIntentConfirmParams params =
//                PaymentIntentConfirmParams.builder()
//                        .setP
//                        .setPaymentMethod("pm_card_visa")
//                        .setReturnUrl("https://www.example.com")
//                        .build();
//
//        try {
//
//            PaymentIntent paymentIntent = resource.confirm(params);
//
//            System.out.println("Resp OK:");
//
//        } catch (Exception ex ) {
//            System.out.println("Error: "+ ex.getMessage() );
//        }



    }
}