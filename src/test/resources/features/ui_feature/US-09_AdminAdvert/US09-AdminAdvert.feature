@UI
@E2E
@US09
@Admin

Feature: US09 Admin girilen ilanları aktif edebilmeli, reddedebilmeli, güncelleyebilmeli


  @US09TC01

  Scenario: Admin, girilen ilanları aktif edebilmeli.

    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir
    And Guncellenmek istenen  Admin ilanda Edit butonuna tiklanir
    And Guncellenmek istenen ilan Active veya deactive edilerek güncellenir
    Then Guncellenmek istenen ilan icin Update butonuna tiklanir
    Then Ilanin basariyla guncellendigi mesajı gorulmeli
    Then İlanın aktif olduğunu doğrula "pembe ev IlanDurumu ACTIVATED olmuyor"


  @US09TC02

  Scenario: Admin, girilen ilanları reddedebilmeli.

    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir
    And Guncellenmek istenen  Admin ilanda Edit butonuna tiklanir
    And Guncellenmek istenen ilan Active veya deactive edilerek güncellenir
    Then Guncellenmek istenen ilan icin Update butonuna tiklanir
    Then Ilanin basariyla guncellendigi mesajı gorulmeli
    Then İlanın aktif olduğunu doğrula "pembe ev IlanDurumu DEACTIVATED olmuyor"

  @US09TC03

  Scenario: Admin, ilanları güncelleyebilmeli.

    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir

    And Guncellenmek istenen  Admin ilanda Edit butonuna tiklanir
    And Guncellenmek istenen ilanda Price güncellenir
    And Guncellenmek istenen ilanda Advert Type güncellenir
    And Guncellenmek istenen ilanda Category güncellenir
    And Guncellenmek istenen ilan Active veya deactive edilerek güncellenir
    And Guncellenmek istenen ilanda Country güncellenir
    And Guncellenmek istenen ilanda City güncellenir
    And Guncellenmek istenen ilanda District güncellenir
    And Guncellenmek istenen ilanda Address güncellenir
    And Guncellenmek istenen ilanda Size güncellenir
    And Guncellenmek istenen ilanda Bedrooms güncellenir
    Then Guncellenmek istenen ilan icin Update butonuna tiklanir
    Then Ilanin basariyla guncellendigi mesajı gorulmeli




