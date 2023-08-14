Feature: Contact feature
#  Verify contact business flows

#  @test1
#  Scenario: Verification of error messages for mandatory fields
#    Given User opens Contact page
#    Then User submits contact form
#    Then User validates error message
#    Then User enters mandatory data
#      |Forename|Email      |Message|
#      |David   |abc@cd.com |Test   |
#    Then User validates error message are gone
#
#  @test2
#  Scenario Outline: Verification success message on valid contact details submission
#    Given User opens Contact page
#    Then User enters mandatory data
#      |Forename  |Email   |Message   |
#      |<Forename>|<Email> |<Message> |
#    Then User submits contact form
#    Then User validates success message
#    Examples:
#      |Forename|Email      |Message|
#      |David   |abc@cd.com |Test1   |
#
#  @test3
#  Scenario Outline:Verification error messages on invalid contact details submission
#    Given User opens Contact page
#    Then User enters mandatory data
#      |Forename  |Email   |Message   |
#      |<Forename>|<Email> |<Message> |
#    Then User submits contact form
#    Then User validates error message
#    Examples:
#      |Forename|Email      |Message |
#      # considering blank data is invalid data for forname and message as what invalid is not specified
#      |        |aaa        |        |
#      |        |           |        |
#      #uncomment below line if want to execute with negative scenario
#      #|David   |abc@cd.com |Test1   |



  Scenario:  Verify the form gets clear
    Given Navigate to borrowing calculator home page
    When  Click on start over button
    Then  Form gets clear