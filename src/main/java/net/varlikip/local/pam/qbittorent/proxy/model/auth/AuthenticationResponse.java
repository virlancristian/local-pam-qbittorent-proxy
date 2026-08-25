package net.varlikip.local.pam.qbittorent.proxy.model.auth;

public class AuthenticationResponse {
    private String errorMessage;
    private String username;
    private String node;

    public AuthenticationResponse(String errorMessage, String username, String node) {
        this.errorMessage = errorMessage;
        this.username = username;
        this.node = node;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
