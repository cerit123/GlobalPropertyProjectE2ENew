@US2 @UI @E2E
Feature: US2_UserLogin Test
  Scenario: Password boş geçildiğinde kayıt işlemi başarısız olmalıdır

    Given Sayfaya gidilir
    When Login sekmesine tiklanir
    And Siteye kaydolunan email adres girilir
    And Password bos birakilir
    Then Password is required uyarisinin geldigi dogrulanir










