Feature: profile_photos tablosunun sutun bilgilerini dogrula

@US13TC02DB
Scenario: TC-02 profile_photos tablosunun sutun bilgilerini dogrula
Given Profile_photos tablosunu icin Database bağlantısı kurulur
And Expected profile_photos data lar duzenlenir
When profile_photos tablosu sutun bilgilerini almak icin query gonderilir
Then profile_photos tablosu sutun bilgileri dogrulanir
