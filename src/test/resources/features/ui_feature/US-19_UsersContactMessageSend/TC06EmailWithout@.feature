@US-19 @Costumer

Feature:   Users Contact Message Send
  Scenario:   Send Message

    Given Contact sekmesi tiklanir
    And   Acilan pencereye gecerli bir first name girilir
    And   Acilan pencereye gecerli bir last name girilir
    And   Gecersiz bir email adresi @ isareti olmadan girilir
    And   Acilan pencereye gecerli bir mesaj girilir
    Then  Send butonuna tiklanmadigi dogrulanir