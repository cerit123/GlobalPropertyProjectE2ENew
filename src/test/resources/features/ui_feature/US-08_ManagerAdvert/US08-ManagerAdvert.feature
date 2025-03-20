@UI
@E2E
@US08
@Manager

Feature: US08 Manager verdiği ilanları görebilmeli, güncelleyebilmeli ve silebilmeli

  @US08TC01

  Scenario: Manager, ilanları güncelleyebilmeli.

    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir
    And Guncellenmek istenen ilanda Edit butonuna tiklanir
    And Guncellenmek istenen ilanda Title güncellenir
    And Guncellenmek istenen ilanda Price güncellenir
    And Guncellenmek istenen ilanda Advert Type güncellenir
    And Guncellenmek istenen ilanda Category güncellenir
    And Guncellenmek istenen ilan Active veya deactive edilerek güncellenir
    #And Guncellenmek istenen ilanda Country güncellenir
    And Guncellenmek istenen ilanda City güncellenir
    And Guncellenmek istenen ilanda District güncellenir
    And Guncellenmek istenen ilanda Address güncellenir
    And Guncellenmek istenen ilanda Size güncellenir
    And Guncellenmek istenen ilanda Bedrooms güncellenir
    Then Guncellenmek istenen ilan icin Update butonuna tiklanir
    Then Ilanin basariyla guncellendigi mesajı gorulmeli



  @US08TC02

  Scenario: Manager, verdiği ilanları silebilmeli..

    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir
    And Silinmek istenen ilan için "Delete" butonuna tıklanir
    And Onay mesajında Yes butonuna tıklanir
    Then Ilanin basariyla silindigi mesajı gorulmeli


  @US-04NegativeTest
  Scenario: Manager, ilan güncelleme sırasında zorunlu alanları boş bıraktığında uyarı mesajı almalı.


    And Back to site butonuna tiklanir
    And Profil Butonuna tiklanir
    And My Adverts sekmesine tiklanir
    And Guncellenmek istenen ilanda Edit butonuna tiklanir
    And Guncellenmek istenen ilanda Title alanı boş bırakılır
    And Guncellenmek istenen ilanda Price alanı boş bırakılır
    And Guncellenmek istenen ilanda Advert Type güncellenmez
    And Guncellenmek istenen ilanda Category güncellenmez
    And Guncellenmek istenen ilan Active veya deactive edilmez
    And Guncellenmek istenen ilanda City güncellenmez
    And Guncellenmek istenen ilanda District güncellenmez
    And Guncellenmek istenen ilanda Address güncellenmez
    And Guncellenmek istenen ilanda Size güncellenmez
    And Guncellenmek istenen ilanda Bedrooms güncellenmez
    #And Guncellenmek istenen ilan için Güncelle butonuna tiklanir
    Then Güncelle butonunun aktif olmadığını ve ilan güncelleme işleminin gerçekleşmediğini kontrol et















