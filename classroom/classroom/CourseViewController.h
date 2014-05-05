//
//  CourseViewController.h
//  classroom
//
//  Created by Kester Guischard on 4/20/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NoteViewController.h"
#import "DocumentViewController.h"
#import "QuestionViewController.h"
#import "LiveDiscussionViewController.h"
#import "User.h"
#import "Course.h"

@interface CourseViewController : UIViewController{
    User *currUser;
    Course *selCourse;
    UISegmentedControl* segCtrl;
    UIView *containerView;
    UIViewController *activeView;
    
}

@property(nonatomic, strong) User *currUser;
@property(nonatomic, strong) Course *selCourse;
@property(nonatomic, strong) UIView *containerView;
@property(nonatomic, strong) UIViewController *activeView;

@end
