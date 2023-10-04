package classes.trait

class Duck implements FlyingAbility, SwimmingAbility {

    @Override
    void jump() {
        println "The duck is jump!!!"
    }

    @Override
    void dive() {
        println "The duck is dive!!!"
    }
}
