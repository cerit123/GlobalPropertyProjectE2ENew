@US2 @UI @E2E
  Feature: US2_UserLogin Test

    Scenario: Kullanici siteye kayit oldugu email adresiyle login yapabilmelidir

      Given sayfaya gidilir
      When Login sekmesine tiklanir
      And Siteye kaydolunan email adres girilir
      And Kullanici passwordu girilir
      And Login sekmesine tiklanir
      Then Login olundugu dogrulanir

