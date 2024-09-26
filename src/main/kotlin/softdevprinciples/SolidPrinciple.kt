package com.bbs.softdevprinciples

/**
 * S: Single Responsibility Principle (SRP)
 * O: Open Close Principle (OCP)
 * L: Liskov Substitution principle (LSP)
 * I: Interface Segregation Principle (ISP)
 * D: Dependency Inversion Principle (DIP)
 */
sealed class SolidPrinciple(shortName: String) {

    /**
     * A class should have only one reason to change.
     * It should have one and only one responsibility.
     */
    class SingleResponsability: SolidPrinciple(shortName = "SRP") {

        // Bad Example: Multiple Responsibilities
        class UserA {
            fun calculatePay() { /* ... */ }
            fun saveToDatabase() { /* ... */ }
            fun sendEmailNotification() { /* ... */ }
        }

        // Good Example: Single Responsibility
        class UserB {
            fun calculatePay() { /* ... */ }
        }
        class UserPersistence {
            fun saveToDatabase(user: UserB) { /* ... */ }
        }
        class UserNotifier {
            fun sendEmailNotification(user: UserB) { /* ... */ }
        }
    }

    /**
     * Software entities (classes, modules, etc.)
     * should be open for extension but closed for modification
     */
    class OpenClose: SolidPrinciple(shortName = "OCP") {

        // Bad Example: Modification required for new shapes
        class AreaCalculatorA {

            fun calculateArea(shape: Any): Double {
                if (shape is Rectangle) {
                    return shape.width * shape.height
                } else if (shape is Circle) {
                    return 3.14 * shape.radius * shape.radius
                }
                // ... more if/else for other shapes
                return 0.0
            }

            class Rectangle(val width: Double, val height: Double)
            class Circle(val radius: Double)
        }

        // Good Example: Extension without modification
        class AreaCalculatorB { // No need to modify for new shapes

            fun calculateArea(shape: Shape): Double {
                return shape.calculateArea()
            }

            interface Shape {
                fun calculateArea(): Double
            }

            class Rectangle(val width: Double, val height: Double) : Shape {
                override fun calculateArea(): Double = width * height
            }
            class Circle(val radius: Double) : Shape {
                override fun calculateArea(): Double = 3.14 * radius * radius
            }
        }
    }

    /**
     * Subtypes should be substitutable for their base types
     * without altering the correctness of the program.
     */
    class LiskovSubstitution: SolidPrinciple(shortName = "LSP") {

        // Bad Example: Violation of LSP
        open class BirdA {
            open fun fly() { /* ... */ }
        }

        class PenguinA : BirdA() {
            override fun fly() {
                throw Exception("Penguins can't fly!")
            }
        }

        // Good Example: Adhering to LSP
        interface BirdB { }

        interface FlyingBird : BirdB {
            fun fly()
        }

        class Eagle : FlyingBird {
            override fun fly() { /* ... */ }
        }

        class Penguin : BirdB { // No need to implement fly()
        }
    }

    /**
     * Clients should not be forced to depend on methods they don't use.
     * Interfaces should be small and specific.
     */
    class InterfaceSegregation: SolidPrinciple(shortName = "ISP") {

        // Bad Example: Fat Interface
        interface Worker {
            fun work()
            fun eat()
            fun sleep()
        }

        // Good Example: Segregated Interfaces
        interface Workable {
            fun work()
        }

        interface Eatable {
            fun eat()
        }

        interface Sleepable {
            fun sleep()
        }

        class Human : Workable, Eatable, Sleepable {
            // ... implementations
            override fun work() { }

            override fun eat() { }

            override fun sleep() { }
        }

        class Robot : Workable {
            // ... only work implementation
            override fun work() { }
        }
    }

    /**
     * High-level modules should not depend on low-level modules.
     * Both should depend on abstractions
     */
    class DependencyInversion: SolidPrinciple(shortName = "DIP") {

        // Bad Example: High-level depends on low level
        class LightA {
            fun turnOn() { /* ... */ }
        }

        class SwitchA {
            private val light = LightA() // Tight coupling
            fun operate() {
                light.turnOn()
            }
        }

        // Good Example: Dependency Inversion
        interface Switchable {
            fun turnOn()
        }

        class LightB : Switchable {
            override fun turnOn() { /* ... */ }
        }

        class Switch(private val device: Switchable) { // Depends on abstraction
            fun operate() {
                device.turnOn()
            }
        }
    }
}