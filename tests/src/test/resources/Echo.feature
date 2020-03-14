Feature: employee echo
  Scenario: client makes call to GET /employee/echo
    When the client calls employee echo
    Then the client receives status code of 200
#    And the client receives server version 1.0
   
   
