package demo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.apache.http.HttpStatus
import spock.lang.Specification

@TestFor(DemoController)
@Mock([Parent, Child])
class DemoControllerSpec extends Specification {
    void 'test check status'() {
        when:
        request.method = 'GET'
        request.contentType = 'application/json'
        new Parent(name: 'XYZ', child: new Child(name: 'Demo')).save()
        params.id = '1'
        request.contentType = 'application/json'
        controller.getParents()

        then:
        response.status == HttpStatus.SC_OK
    }
}
