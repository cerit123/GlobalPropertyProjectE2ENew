@US07
Feature: Manager satilik ilan oluşturabilmeli



  @US07TC01
  Scenario: manager rolündeki kullanıcı satilik ilan oluştururken "common information", "adress information" ve "properties" bilgilerini girebilmeli
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Title kismi girilir
    And Description kismi girilir
    And Price kismi girilir
    And Advert type kismina Sale verisi grilir
    And Category kismina  veri girilir
    #    ADDRESS INFORMATION
    And Country kismina  veri girilir
    And City kismina veri girilir
    And District kismina veri girilir
    And Address kismina veri girilir
#    PROPERTIES
    And Size kismina veri girilir
    And Year of build kismina veri girilir
    And Furniture kismina veri girilir
    And Maintenance Fee kismina veri girilir
    And Bedrooms kismina veri girilir
    And Bathrooms kismina veri girilir
    And Garage kismina veri girilir
    And Terrace kismina veri girilir
    And Flat kismina veri girilir
    And GARDEN kismina veri girilir
    And Flower Garden kismina veri girilir
    And Central AC kismina veri girilir
    And Central heating kismina veri girilir
    And Flattisa kismina veri girilir
    And Kullanici ilan icin fotograf ekler
    Then Bilgiler eksiksiz şekilde girilmeli ve hatasız kaydedilmelidir

  @US07TC02
  Scenario:  Title ve Description alanları boş bırakıldığında, ilgili hata mesajları görüntülenmeli
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Title kismi bos birakilir
    And Description kismi bos birakilir
    And Title kismi bos birakilir
    And Description kismi bos birakilir
    Then Title bos birakildiginda hata mesaji goruntulendi
    Then Description bos birakildiginda hata mesaji goruntulendi

  @US07TC03
  Scenario:  Adres alanı boş bırakıldığında, "newAdvertPageTranslations.requiredAddress" uyarı mesajı görüntülenmeli
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Address kismina tiklanilir
    And Description kismi bos birakilir
    And Address kismina tiklanilir
    Then Address bos birakildiginda hata mesaji goruntulendi

  @US07TC04
  Scenario:  Kullanıcı satilik ilan oluştururken resim ekleyebilmeli
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Kullanici ilan icin fotograf ekler
    Then Fotograf yuklendiginda hata mesaji kayboldu


  @US07TC05
  Scenario:  Kullanıcı satilik ilan oluştururken 3MB dosya boyutundan fazla olan bir resim  dosyası ekleyememelidir
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Kullanici ilan icin 3mb boyutundan yuksek bir fotograf ekler
    Then Fotograf yuklendiginda hata mesaji gosterildi


  @US07TC06
  Scenario:Kullanıcı, zorunlu alanları doldurmadan "Create" butonuna tıklayamamalı veya buton pasif olmalı.
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Title kismi bos birakilir
    And Description kismi bos birakilir
    And Advert type kismina Sale verisi grilir
    And Category kismina  veri girilir
    #    ADDRESS INFORMATION
    And Country kismina  veri girilir
    And City kismina veri girilir
    And District kismina veri girilir
    And Address kismina tiklanilir
    And GARDEN kismina veri girilir
    Then Create butonu pasif olmalidir


  @US07TC07
  Scenario: Kullanıcı, tüm zorunlu alanları doldurduktan sonra "Create" butonuna tıklayarak ilan oluşturabilmeli.
    Given Sayfaya gidilir
    When Manager olarak giris yapilir
    And Dashboard sayfasindan ana sayfaya geri donulur
    And Create property sekmesine tiklanir
    #    COMMON INFORMATION
    And Title kismi girilir
    And Description kismi girilir
    And Price kismi girilir
    And Advert type kismina Sale verisi grilir
    And Category kismina  veri girilir
    #    ADDRESS INFORMATION
    And Country kismina  veri girilir
    And City kismina veri girilir
    And District kismina veri girilir
    And Address kismina veri girilir
    And Kullanici ilan icin fotograf ekler
    And Create butonu aktif olmalidir
    Then Islem basarili, kullanici my adverts sayfasina aktarildi



