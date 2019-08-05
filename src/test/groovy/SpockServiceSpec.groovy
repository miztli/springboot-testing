import com.example.testing.services.impl.SpockDependency
import com.example.testing.services.impl.SpockService
import spock.lang.Specification

class SpockServiceSpec extends  Specification
{

  def 'testing a stubbed dependency'() {
    given: 'A spock service with a stubed dependency'
      SpockDependency spockDependency = Stub()
      SpockService spockService = new SpockService(spockDependency)
      // Stub method
      spockDependency.getNames() >> ['barbara', 'mariana'] // Stubbed dependency will always return 2 values

    when:
      List<String> names = spockService.retreiveNames()
      spockService.storeName('new name')
      int size = spockService.retrieveSize()

    then:
      size == 0 // even though a new name was added, list size remains in 0 because of the stubbed dependency
      // values returned from stubbed method
      names.size() == 2
      names.get(0) == 'barbara'
      names.get(1) == 'mariana'
  }

}
