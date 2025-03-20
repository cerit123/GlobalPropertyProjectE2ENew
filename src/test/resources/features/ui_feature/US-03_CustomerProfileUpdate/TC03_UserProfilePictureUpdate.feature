@US03 @UI @E2E
Feature: US3_CustomerProfileUpdate Test
  Scenario: Kullanici Profile Photo butonuna tıklayarak profil resmi ekleyebilmeli

    Given Sayfaya gidilir
    When Login sekmesinee tiklanir
    And Profil butonuna tiklanir
    And My Profile sekmesine tiklanir
    And Profile photo sekmesine tiklanir
    And Select sekmesiyle yeni profil resmi secilir
    And Save butonu tiklanir
    Then Profil resminin basarili bir sekilde eklendigi dogrulanir














