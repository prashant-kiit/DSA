
def decorate(decoratable):
    def decorateHelper():
        print("Decoration 1")
        decoratable()
        print("Decoration 2")
    return decorateHelper

@decorate
def main():
    print("Main function")

#decorate(main)()

main()