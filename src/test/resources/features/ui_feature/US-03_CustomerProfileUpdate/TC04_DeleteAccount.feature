@US03 @UI @E2E
Feature: US3_CustomerProfileUpdate Test
  Scenario: Kullanici Hesabını silebilmeli

    Given Sayfaya gidilir
    When Login sekmesinee tiklanir
    And Profil butonuna tiklanir
    And My Profile sekmesine tiklanir
    And Delete Account sekmesine tiklanir
    And Silme islemini gerceklestirmek icin gerekli olan kullanici password'u girilir
    And Delete Account butonuna tiklanir
    And Are you sure to delete your account permanently? confirmation sorusu icin Yes tiklanir
    Then Hesabin silindigi dogrulanir















