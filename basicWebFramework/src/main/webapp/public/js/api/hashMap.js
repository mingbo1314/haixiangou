/**
 * Created by yp-tc-m-2503 on 15/1/7.
 */

Array.prototype.remove = function(s) {
    for (var i = 0; i < this.length; i++) {
        if (s == this[i])
            this.splice(i, 1);
    }
}

function HashMap() {
    this.keys = new Array();
    this.data = new Object();

    this.put = function(key, value) {
        if(this.data[key] == null){
            this.keys.push(key);
        }
        this.data[key] = value;
    };
    this.get = function(key) {
        return this.data[key];
    };
    this.remove = function(key) {
        this.keys.remove(key);
        this.data[key] = null;
    };
    this.each = function(fn){
        if(typeof fn != 'function'){
            return;
        }
        var len = this.keys.length;
        for(var i=0;i<len;i++){
            var k = this.keys[i];
            fn(k,this.data[k],i);
        }
    };
    this.entrys = function() {
        var len = this.keys.length;
        var entrys = new Array(len);
        for (var i = 0; i < len; i++) {
            entrys[i] = {
                key : this.keys[i],
                value : this.data[i]
            };
        }
        return entrys;
    };
    this.isEmpty = function() {
        return this.keys.length == 0;
    };
    this.size = function(){
        return this.keys.length;
    };
    this.toString = function(){
        var s = "{";
        for(var i=0;i<this.keys.length;i++,s+=','){
            var k = this.keys[i];
            s += k+"="+this.data[k];
        }
        s+="}";
        return s;
    };
}

function testMap(){
    var m = new HashMap();
    m.put('key1','Comtop');
    m.put('key2','key2内容');
    m.put('key3','key3内容');
    alert("init:"+m);

    m.put('key1','key1xxxx');
    alert("set key1:"+m);

    m.remove("key2");
    alert("remove key2: "+m);

    var s ="";
    m.each(function(key,value,index){
        s += index+":"+ key+"="+value+"\n";
    });
    alert(s);
}
