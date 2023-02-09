Feature: User product search on Hitachi page through RestAPI

#  The following test case navigate to the Hitachi webpage and search for the key. if keyword is presen then it clicks the first
#  returned search else displays search for keyword is not present


  Scenario Outline: Keyword search validation using Rest API
    Given User hits Hitachi page endpoint using the <keyword>
    Then User verifies the <result> for <keyword> search
    Examples:
      |keyword|result|
      |Insurance|present|
      |Market   |present|
      |Builder  |present|
      |Construction|present|
      |Archana     |not present|
      |**************|present|
      |abcdefghijkl  |not present|
      |000000        |present|
      |              |present|
      |12356894.3263 |not present|
