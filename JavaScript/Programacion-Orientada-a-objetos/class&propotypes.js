class Film {
  constructor(name, id) {
    this.name = name;
    this.id = id;
  }
  play() {
    return `play film... ${this.name}`;
  }
}
const filmOne = new Film("Harry Potter", Math.random());
const filmTwo = new Film("Rambo", Math.random());

class Series extends Film {
  constructor(name, id, number) {
    super(name, id);
    this.number = number;
  }
  playChapter() {
    return `play series... ${this.name} (chapter ${this.number})`;
  }
}
const seriesOne = new Series("Breaking Bad", Math.random(), 1);

//////////////////////////////////////////////////////////////////////////////

function Animal() {}
Animal.prototype = {
  constructor: Animal,
  eat: function() {
    return `ñom ñom ñom`;
  }
};

function Dog() {}
Dog.prototype = Object.create(Animal.prototype);

let beagle = new Dog();
console.log(beagle.eat());
