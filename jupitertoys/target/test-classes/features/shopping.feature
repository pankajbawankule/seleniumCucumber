Feature: Shopping feature
  Verify shopping business flows

  @test4
  Scenario: Verification user selected items on cart
    When User opens Shop page
    And User selects items
      |Item Name    |Quantity |
      |Funny Cow    |2        |
      |Fluffy Bunny |1        |
    Then User opens Cart page
    Then User verifies selected items availability in cart


