@US-13 @Manager

Feature:US-13_Manager Accept Appointment Test

  Scenario:Manager randevu isteklerini red edebilmelidir

    Given siteye geri don kismina tiklamalidir
    When profile tiklamalidir
    And Tur Taleplerime tiklamalidir
    And Tur Cevaplarim listesi goruntulenir.
    And reddetme kismina tiklanir
    And  cikan reddetme kutusuna yes'e tiklanir
    Then reddedildigine dair yazi kontrol edilir.
