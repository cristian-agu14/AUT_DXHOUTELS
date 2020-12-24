#Author: cristian.agu14@gmail.com
@find-hotel
Feature: Find the hotel in DX HOTEL page
  I want to automate the find hotels for help to Carolina in her work

  @find-hotel-cheaper
  Scenario Outline: I need to find the cheaper hotel
    Given I want to open dxhoutels page
    And I into the location:<location> check in:<checkin> check out:<checkout> rooms:<rooms> adults:<adults> and children:<children>
    When The robot saves the data finded
    And The robot finds the cheaper hotel
    Then The robot shows the cheaper hotel
    And check more outcomes

    Examples: 
      | location      | checkin    | checkout   | rooms | adults | children |
      | San Francisco | 12/25/2020 | 12/26/2020 |     1 |      1 |        0 |
