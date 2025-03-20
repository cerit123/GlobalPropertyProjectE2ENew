@US03 @UI @E2E
Feature: US3_CustomerProfileUpdate Test
  Scenario: Kullanici My Profile altindaki profil bilgilerini gorebilmeli ve degistirebilmeli

    Given Sayfaya gidilir
    When Login sekmesinee tiklanir
    And Profil butonuna tiklanir
    And My Profile sekmesine tiklanir
    And First name guncellenir
    And Last name guncellenir
    And Phone guncellenir
    And Email guncellenir
    And Update butonuna tiklanir
    Then Profil bilgilerinin degistirildigi dogrulanir












