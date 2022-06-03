package by.teachmeskills.eshop.utils;

public enum PagesPathEnum {
    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signin.jsp"),
    CATEGORY_PAGE("category.jsp"),
    CART_PAGE("cart.jsp"),
    PRODUCT_PAGE("product.jsp"),
    REGISTER_PAGE("register.jsp"),
    STATUS_REGISTER_PAGE("statusregister.jsp"),
    PROFILE_PAGE("profile.jsp"),
    ORDER_PAGE("order.jsp"),
    STATUS_FAIL_PAGE("statusfail.jsp"),
    SEARCH_PRODUCT_PAGE("searchproduct.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

