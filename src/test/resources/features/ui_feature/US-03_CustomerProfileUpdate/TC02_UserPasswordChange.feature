@US03 @UI @E2E
Feature: US3_CustomerProfileUpdate Test
  Scenario: Kullanici Change Password butonuna tıklayarak password değiştirebilmeli

    Given Sayfaya gidilir
    When Login sekmesinee tiklanir
    And Profil butonuna tiklanir
    And My Profile sekmesine tiklanir
    And Change password sekmesine tiklanir
    And Current password girilir
    And Sistem gerekliliklerine gore New password girilir
    And Confirm password kutucuguna yeni olusturulan password tekrar girilir
    And Change butonuna tiklanir
    Then Password'un basarili bir sekilde degistirildigi dogrulanir













