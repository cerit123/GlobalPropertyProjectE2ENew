@API-US-04-10

  Feature:
    @apiAdmin
    Scenario: TC-01 | tam yetkili olarak reklam ilanı verebilmeli
      Given   set the url
      And     yetkili post işlemi için payload oluşturulur
      When    yetkili yapılan post işlemi için response alınır
      Then    to do assertion- ilanın verildiği doğrulanır

    Scenario: TC-02 | yetkisiz olarak reklam ilanı verilememeli
      Given   token alınmaz
      And     set the url
      And     yetkisiz post işlemi için payload oluşturulur
      When    yetkisiz yapılan post işlemi response alınır
      Then    to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı görülür

    @apiAdmin
    Scenario: TC-03 | oluşturualn reklam get işlemi ile görülebilmeli
      Given  set the url (url nin sonuna oluşturlan reklamın id si eklenir)
      When   oluşturulan advert type get işlemi için response alınır
      Then   to do assertion- 200 status code ile verilen ilan görünür

    Scenario: TC-04 | id numarası ile verilen ilanınları yetkisi olmadan görememeli
      Given  token alınmaz
      When   set the url (url nin sonuna oluşturlan reklamın id si eklenir)
      And    oluşturulan advert type get işlemi için response alınır
      Then   to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı alınmalı

    Scenario: TC-05 | yetkisi olmadan da bütün ilanları görebilmeli
      Given  token alınmaz
      When   set the url (url nin sonuna all eklenir)
      And    oluşturulan advert type get işlemi için response alınır
      Then   to do assertion- 200 kodu ile tüm ilanlar görünür

      @apiAdmin
    Scenario: TC-06 | yetkili olarak advert type üzerinde değişiklik yapabilmeli
      Given  set the url (url nin sonuna oluşturlan reklamın id si eklenir)
      When   set the expected data- title de yapılmak istenen değişiklik yazılır
      And    değiştirilen advert type put işlemi için response alınır
      Then   to do assertion- 200 status code ile verilen ilan görünür

    Scenario: TC-07 | yetkisi omadan ilan üzerinde değişiklik yapamamalı
      Given  set the url (url nin sonuna oluşturlan reklamın id si eklenir)
      When   set the expected data title de yapılmak istenen değişiklikler yazılır
      And    yetkisiz olarak değiştirilmek istenen advert type put işlemi için response alınır
      Then   to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı alınmalı

      @apiAdmin
     Scenario: TC-08 | yetkili olarak advert type silebilmeli
      Given  set the url (url nin sonuna oluşturlan reklamın id si eklenir)
      When   payloadta islem yapılmaz
      And    delete islemi için response oluşturulur
      Then   to do assertion- 200 status code ile verilen ilan görünür

    Scenario: TC-09 | yetkisiz olarak ilanlar silinememeli
      Given  set the url (url nin sonuna oluşturlan reklamın yeni id si eklenir)
      When   payloadta islem yapılmaz
      And    delete islemi için yeni id li advert typeresponse oluşturulur
      Then   to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı alınmalı



    @API-US-10@apiAdmin
  Scenario: GetCitiesId | city idleri getirilir bilgilerini görebilmeli
    Given   city idsi almak için url düzenlenir
    When    city idleri getirilir ve bir list e atılır



    @API-US-10 @apiAdmin
  Scenario: TC01 | yetkilendirilmiş hesap ile ilçe bilgilerini görebilmeli
    Given   set the url (url adresinin sonun rastgele cityId girilir)
    And     get işlemi ile seçilen ilçe response atılır
    Then    to do assertion- 200 status code ile verilen ilan görünür

    @API-US-10
  Scenario: TC02 | yetkilendirilmemiş hesap ile ilçe bilgilerini görememeli
    Given   set the url (url adresinin sonun rastgele cityId girilir)
    When    get işlemi ile seçilen ilçe response atılır
    Then   to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı alınmalı




