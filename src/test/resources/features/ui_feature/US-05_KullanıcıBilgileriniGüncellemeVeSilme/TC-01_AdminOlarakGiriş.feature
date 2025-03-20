@US-05 @UI

  Feature:"Admin oluşturulan Customer kullanıcısını; Admin ve Manager yapılabilmeli,
    bilgileri güncellenebilmeli ve kullanıcılar silinebilmeli"

    Scenario:Sayfaya Admin olarak giriş yapılabilmeli

      Given  Sayfaya gidilir
      When Login sekmesine tiklanir
      And Siteye kaydolunan email adresi girilir
      And Kullanici password girilir
      And  Login sekmesine tiklanir
      Then Admin olarak giriş yapılabilmeli