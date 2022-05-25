package by.teachmeskills.eshop.utils;

public enum CommandsEnum {

    HOME_PAGE_COMMAND("start_page"),
    SIGN_IN_COMMAND("sign-in"),
    CATEGORY_PAGE_COMMAND("category-redirect"),
    REDIRECT_SHOPPING_CART_COMMAND("redirect-to-shopping-cart"),
    REDIRECT_PRODUCT_COMMAND("product-redirect"),
    REGISTER_COMMAND("register"),
    STATUS_REGISTER_COMMAND("status_register"),
    ORDER_COMMAND("order"),
    ADD_PRODUCT_TO_CART("add-product-to-cart"),
    DELETE_PRODUCT_FROM_CART("remove-product-from-cart"),
    REDIRECT_PROFILE("redirect-to-profile")
    ;



    private final String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

