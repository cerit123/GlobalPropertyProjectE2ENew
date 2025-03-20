@US-05 @UI
Feature:US_05	"Admin oluşturulan Customer kullanıcısını; Admin ve Manager yapılabilmeli,
  bilgileri güncellenebilmeli ve kullanıcılar silinebilmeli"

  Scenario:Oluşturulan kullanıcı silinebilmeli

    Given  Sayfaya gidilir
    When   Login sekmesine tiklanir
    And    Siteye kaydolunan email adresi girilir
    And    Kullanici password girilir
    And    Login sekmesine tiklanir
    And    Admin olarak giriş yapılabilmeliır
    And    Kullanıcı sekmesine tıklanır
    And    Oluşturulan kullanıcı bilgileri görülebilmeli
    And   Delete sekmesine tıklanılır
    Then  Oluşturulan kullanıcı silinebilir olmalı