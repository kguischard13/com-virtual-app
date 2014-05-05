//
//  MainMenuController.h
//  classroom
//
//  Created by Kester Guischard on 4/20/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CourseViewController.h"
#import "User.h"
#import "Course.h"

@interface MainMenuController : UIViewController <UINavigationControllerDelegate>{
    int numofCourse;
    User *currUser;
    UIButton *CourseB;
    id reponse;
    CourseViewController *courseViewCtrl;
}

@property int numofCourse;
@property id response;
@property(nonatomic, strong) User *currUser;
@property (nonatomic, strong) UIButton *CourseB;
@property (nonatomic, strong) CourseViewController *courseViewCtrl;

@end
