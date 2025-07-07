package controller;

import dao.UserDAO;
import model.User;
import view.MasterView;
import view.PlayerView;

public class UserController {
    private UserDAO userdao = new UserDAO();

    public boolean signUp(String username, String password) {
        boolean isSignedUp = false;
        User user = new User(username, password);
        isSignedUp = userdao.insertUser(user);
        if(isSignedUp){
            return true;
        }else{
            return false;
        }
    }

    public boolean longIn(String username, String password) {
        boolean isloggedin = false;
        User user = new User(username,password);
        isloggedin = userdao.checkUser(user);
        if (isloggedin){
            if (user.isGameMaster()){
                MasterView.showView();
            } else {
                PlayerView.gameStart();
            }
            return true;
        }else {
            return false;
        }
    }
}
