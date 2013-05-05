Inquiry service for Indonesian Provinsi, Kabupaten and Kecamatan
===================

Tools
-------------------
* IDE - Netbeans 7.2
* DB - MySQL
* Framework - Hibernate ORM - JaxWS 2.2
* Build Tool - Maven
* Programming Language - Java

How to Build
-------------------
1. Make sure you have Internet Connection
2. Open project using Netbeans
3. Right click on your project, and build 
    (be patience, Maven will download libraries needed automatically)
4. Press F6 to Run your project
5. You will find your service on this url, http://localhost:8084/GISService/Service.

Messaging
--------------------
There are 3 requests provided, getProvinsis, getKabupatens and getKecamatans. Messaging is done by using xml formats (webservice), and you could get this project's wsdl from  browser (http://<ip>/GISService/Service?wsdl) or from Service.wsdl file.

Here is the example of getProvinsis request.

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.gis.edw.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getProvinsis/>
   </soapenv:Body>
</soapenv:Envelope>
```

and here is the response
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:getProvinsisResponse xmlns:ns2="http://service.gis.edw.com/">
         <return>
            <id>11</id>
            <nama>Aceh</nama>
         </return>     
		.....		 
		<return>
            <id>94</id>
            <nama>Papua</nama>
		</return>
      </ns2:getProvinsisResponse>
   </S:Body>
</S:Envelope>
```

Appreciations
--------------------
Provinsi, kabupaten and kecamatan datas are provided by kind permission from Panji09 (http://www.kaskus.co.id/thread/518298ae8227cf927f000003/sharedatabase-wilayah-indonesia) and from http://mfdonline.bps.go.id/.