Feature: User product search on Hitachi page

#  The following test case navigate to the Hitachi webpage and search for the key. if keyword is presen then it clicks the first
#  returned search else displays search for keyword is not present

  Scenario Outline: Keyword search validation
    Given User navigates to the Hitachi page
    When User searches the product details using <keyword>
    Then search returns the <result> for <keyword>
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
