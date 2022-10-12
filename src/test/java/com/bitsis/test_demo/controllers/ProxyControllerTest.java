package com.bitsis.test_demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProxyController.class)
public class ProxyControllerTest {

    @Autowired
    private MockMvc mvc;

    private final String requestJson = """
            {
              "_id": "Sasdfsa12234145ADfsd",
              "tenant": "CCH/PTC/Cosmos",
              "incomingConfig": {
                "incomingEndpoint": "/ConsultaSaldoPrestamo",
                "requestValues": [
                  {
                    "name": "Institucion",
                    "defaultValue": "DEFAULT",
                    "description": "Campo para XXXXXX",
                    "required": true
                  },
                  {
                    "name": "Secuencia",
                    "defaultValue": "DEFAULT2",
                    "description": "Campo para XXXXXX",
                    "required": false
                  },
                  {
                    "name": "Origen",
                    "defaultValue": "DEFAULT",
                    "description": "Campo para XXXXXX",
                    "required": true
                  },
                  {
                    "name": "data.text",
                    "defaultValue": "DEFAULT",
                    "description": "Campo para XXXXXX",
                    "required": true
                  }
                ],
                "errorResponse": {
                  "validationFields": [
                    {
                      "name": "success",
                      "value": "false"
                    }
                  ],
                  "errorParameters": [
                    {
                      "name": "codigoRespuesta",
                      "matchPattern": [
                        {
                          "field": "code",
                          "defaultValue": "06",
                          "matchers": [
                            {
                              "match": "404|505|103",
                              "value": "14"
                            },
                            {
                              "match": "54|201|403",
                              "value": "61"
                            }
                          ]
                        }
                      ]
                    },
                    {
                      "field": "Secuencia",
                      "value": "${Secuencia}"
                    }
                  ],
                  "defaultErrorParameters": [
                    {
                      "name": "codigoRespuesta",
                      "defaultValue": "06"
                    },
                    {
                      "field": "Secuencia",
                      "value": "${Secuencia}"
                    },
                    {
                      "field": "status",
                      "defaultValue": "ERROR"
                    }
                  ]
                },
                "responseValues": [
                  {
                    "name": "codigoRespuesta",
                    "value": "${transactionId}",
                    "defaultValue": "32342343",
                    "description": "Campo para XXXXXX",
                    "required": true
                  },
                  {
                    "name": "autorizacion",
                    "value": "${operationId}",
                    "defaultValue": "123",
                    "description": "Campo para XXXXXX",
                    "required": false
                  },
                  {
                    "name": "nombre",
                    "value": "concat(${firstName}, ${secondName}, ${firstLastName}, ${secondLastName})",
                    "defaultValue": "DEFAULT",
                    "description": "Campo para XXXXXX",
                    "required": true
                  },
                  {
                    "name": "montoCuota",
                    "value": "${amount} + ${penalties}",
                    "defaultValue": "DEFAULT",
                    "description": "Campo para XXXXXX",
                    "required": true
                  }
                ]
              },
              "outcomeConfig": {
                "outcomeEndpoint": "https://api.bowpi.com/bowpi/feo/${Origen}/",
                "method": "PUT/GET/POST/OPTIONS?",
                "headers": [
                  {
                    "name": "HeaderX",
                    "value": "${field1} + 5",
                    "type": "text/number/date(con formato)"
                  },
                  {
                    "name": "ContentType",
                    "defaultValue": "application/json",
                    "type": "text/number/date(con formato)"
                  }
                ],
                "bodyParameters": [
                  {
                    "name": "externalId",
                    "value": "concat(${data.text}, 'ddd') "
                  },
                  {
                    "name": "posId",
                    "defaultValue": "5",
                    "type": "text/number/date(con formato)"
                  }
                ],
                "queryParameters": [
                  {
                    "name": "testId",
                    "value": "${field2}"
                  },
                  {
                    "name": "posId",
                    "defaultValue": "5",
                    "type": "text/number/date(con formato)"
                  }
                ]
              }
            }
            """;

    @Test
    public void proxyEndpointSimpleTest() throws Exception {
        mvc.perform(post("/api/proxy")
                        .contentType("application/json")
                        .content(requestJson))
                        .andExpect(status().isOk());
    }
}
