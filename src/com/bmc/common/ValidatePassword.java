package com.bmc.common;

public class ValidatePassword {
	
	public boolean checkPassInput(String password) {
		
		if ( password.isEmpty() )
            return false;
        else if ( password.contains( " " ) )
            return false;
        else if ( password.length() < 8 )
            return false;
        else if ( ! password.matches( "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" ) )
            return false;
        else if ( password.matches( "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" ) )
            return false;
		
		return true;
	}

}
