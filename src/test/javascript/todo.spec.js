describe('testing basic functions', function(){

    //"document" doesn't exist in the testing context
    it('should return emptystring', function () {
        var parameter_map = new Array();
        expect(createGetParameters(parameter_map)).toBe("");
    });

    it('should return ?owner=Blanche', function () {
        var parameter_map = new Array();
        parameter_map["owner"] = "Blanche";
        expect(createGetParameters(parameter_map)).toBe("?owner=Blanche");
    });

    it('should return ?owner=Blanche', function () {
        var parameter_map = new Array();
        parameter_map["owner"] = "Blanche";
        parameter_map["limit"] = "17";
        expect(createGetParameters(parameter_map)).toBe("?owner=Blanche&limit=17");
    });

});