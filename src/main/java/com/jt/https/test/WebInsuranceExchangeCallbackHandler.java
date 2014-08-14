
/**
 * WebInsuranceExchangeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.jt.https.test;

    /**
     *  WebInsuranceExchangeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WebInsuranceExchangeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WebInsuranceExchangeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WebInsuranceExchangeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for endorsementApplyConfirm method
            * override this method for handling normal response from endorsementApplyConfirm operation
            */
           public void receiveResultendorsementApplyConfirm(
                    com.jt.https.test.WebInsuranceExchangeStub.EndorsementApplyConfirmResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from endorsementApplyConfirm operation
           */
            public void receiveErrorendorsementApplyConfirm(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for policyNoApply method
            * override this method for handling normal response from policyNoApply operation
            */
           public void receiveResultpolicyNoApply(
                    com.jt.https.test.WebInsuranceExchangeStub.PolicyNoApplyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from policyNoApply operation
           */
            public void receiveErrorpolicyNoApply(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for policyApplyConfirm method
            * override this method for handling normal response from policyApplyConfirm operation
            */
           public void receiveResultpolicyApplyConfirm(
                    com.jt.https.test.WebInsuranceExchangeStub.PolicyApplyConfirmResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from policyApplyConfirm operation
           */
            public void receiveErrorpolicyApplyConfirm(java.lang.Exception e) {
            }
                


    }
    