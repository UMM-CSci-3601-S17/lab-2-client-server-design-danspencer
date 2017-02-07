describe('testing basic functions', function(){

    /*"document" doesn't exist in the testing context
    it('should return emptystring', function () {

        document.getElementById('owner_name_enabled').checked = true;
        document.getElementById('todo_filter_owner_name').value = "Blanche";
       expect(createGetParameters()).toBe("?owner=Blanche");
    });*/



/**
    it('should return the correct string length', function(){
        expect(testStringLength("kittens")).toEqual(7);
    });

    it('returnKittens should return kittens', function(){
        expect(returnKittens()).toBe("kittens");
    });

    ////this test should fail.
    it('this test should fail!', function(){
        expect(returnKittens()).not.toBe("Not kittens!");
    });*/
});