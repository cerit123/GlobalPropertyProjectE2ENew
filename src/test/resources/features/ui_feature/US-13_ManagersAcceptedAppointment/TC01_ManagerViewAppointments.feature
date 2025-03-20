@US-13 @Manager

Feature:US-13_Manager Accept Appointment Test

  Scenario:Manager randevu isteklerini gorebilmelidir

    Given siteye geri don kismina tiklamalidir
    When profile tiklamalidir
    And ilanlarima tiklanmalidir
    Then ilanlarim listesindeki isim,durum,tur tarihi ,saat goruntulenebiliyor mu  kontrol edilir.