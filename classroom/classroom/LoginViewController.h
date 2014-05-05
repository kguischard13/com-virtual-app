//
//  LoginViewController.h
//  classroom
//
//  Created by Kester Guischard on 4/18/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainMenuController.h"

@interface LoginViewController : UIViewController <UINavigationControllerDelegate, UITextFieldDelegate>{
    UILabel *UserL, *PWordL;
    UITextField *UserText, *PWordText;
    UIButton *LoginBtn, *CancelBtn;
    MainMenuController *mainmenuCtrl;
}

@property (nonatomic, strong) UILabel *UserL, *PWordL;
@property (nonatomic, strong) UITextField *UserText, *PWordText;
@property (nonatomic, strong) UIButton *LoginBtn, *CancelBtn;
@property (nonatomic, strong) MainMenuController *mainmenuCtrl;
@end
