package demo

import grails.converters.JSON

class DemoController {

    def getParents() {
        def parentList = Parent.findAllById(params?.id)
        JSON.use('deep')
        render parentList as JSON
    }
}
