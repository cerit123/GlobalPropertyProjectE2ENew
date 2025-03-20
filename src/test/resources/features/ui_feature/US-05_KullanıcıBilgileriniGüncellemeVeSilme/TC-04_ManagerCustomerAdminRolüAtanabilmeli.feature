@US-05 @UI
Feature:US_05	"Admin oluşturulan Customer kullanıcısını; Admin ve Manager yapılabilmeli,
  bilgileri güncellenebilmeli ve kullanıcılar silinebilmeli"

  Scenario:Manager, Customer ve Admin rolü atanabilmeli

    Given  Sayfaya gidilir
    When   Login sekmesine tiklanir
    And    Siteye kaydolunan email adresi girilir
    And    Kullanici password girilir
    And    Login sekmesine tiklanir
    And    Admin olarak giriş yapılabilmeliır
    And    Kullanıcı sekmesine tıklanır
    And    Oluşturulan kullanıcı bilgileri görülebilmeli
    And   Günceleme sekmesine tıklanılır
    Then  Günceleme yapıldığı doğrulanır.