Feature: Parking Lot Assignment

  Scenario: assign a user to an available parking lot in a building
    When the user with id 1 asks for an assignment to the building "1"
    Then the client receives status code of 200
    And the parking lot result is "X"
   
   
#  Scenario: get assigned parking lot
#    When the user with id 1 assigned parking lot
#    Then the user receives status code of 200
#    And the parking lot result is X
   
#  Scenario: get not assigned parking lot
#    When the user with id 1 assigned parking lot
#    Then the user receives status code of 200
#    And the parking lot result is empty   
   