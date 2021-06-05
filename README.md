# HttpMockServer

Read about what is Mock server and its usecases at <a href="https://www.mock-server.com/#what-is-mockserver">here</a>.<BR>
But my aim is to keep it simple so that QA engineers can setup integration tests; with zero code at both the Client and Server; only with configuration changes.

This server is a BLACK BOX, user need not to know the language it is implemented, since they were never going to make changes to it.
Whereas end user will be going to create request config file for each different request at the same system it is running.

Similarly the client side also no code changes required. There is only three config changes required at client.
1. Mock server host
2. Mock server port
3. Request config file location at Mock server in HTTP Header.

For each request has config file location at mock server.
Mock server loads the config, it understads the response to be returned, response headers to be added for the that request via config file and build those 
and return it back to the request. 

In future the request config file configuration will support callback payload, proxy configuration and many more.
The request config file is json file and its payload syntax is defined in this project.

Each request config file will create a session object to store session specific information, e.g.) You want to return different response for every fourth request.

In future we will add template engine to fill dynamic values in the response via request OR from DB (file system specific).
But I will ensure only configuration changes and no code changes at either side.


  
Sample request config file
<PRE>  
{
  "responseConfig": {
    "headers": {
      "Content-Type": "application/json"
    },
    "responseFilePath": "/tmp/httpResponseMock/helloworld.response.config"
  },
  "serverConfig" : {},
  "callbackConfig" : {}
}
</PRE>  

<code>responseFilePath</code> is the file that contains payload to be returned for the request.

So all we need now is to add request config file path as header "Http-Mock-Config-File"  
  
  
  
