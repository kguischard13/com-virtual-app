//
//  CourseViewController.m
//  classroom
//
//  Created by Kester Guischard on 4/20/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import "CourseViewController.h"


#define frameWidth self.view.frame.size.width
#define frameHeight self.view.frame.size.height

@interface CourseViewController ()

@end

@implementation CourseViewController

@synthesize selCourse,currUser, containerView, activeView;

// have an array of controllers that will be in the uiview ie the notes ctrl, documentsctrl, questionctrl, and live discussionctrl.


- (void)viewDidLoad
{
    [super viewDidLoad];
    self.view.backgroundColor = [UIColor colorWithRed:.22 green:.72 blue:.80 alpha:1.0];
    self.title = selCourse.CourseTitle;
    
    NSArray *buttonNames = [NSArray arrayWithObjects:@"Notes", @"Documents", @"Questions", @"Live Discussion", nil];
    segCtrl = [[UISegmentedControl alloc] initWithItems: buttonNames];
    segCtrl.tintColor = [UIColor blackColor];
    segCtrl.frame = CGRectMake(0, 65, frameHeight, 35);
    segCtrl.backgroundColor = [UIColor whiteColor];
    //segCtrl.selectedSegmentIndex = 0;//initializes the index to 1(documents)
    NSDictionary *textAttributes = [NSDictionary dictionaryWithObjectsAndKeys:[UIFont boldSystemFontOfSize:24], NSFontAttributeName, nil]; //sets the font for the segment titles
    [segCtrl setTitleTextAttributes:textAttributes forState:UIControlStateNormal];
    segCtrl.momentary = YES;
    [segCtrl addTarget:self action:@selector(SelectedSegment:) forControlEvents: UIControlEventValueChanged];
    [self.view addSubview:segCtrl ];
    
    
    CGRect  viewRect = CGRectMake(0, 100, frameHeight, frameWidth);
    containerView = [[UIView alloc] initWithFrame:viewRect];
    [self.view addSubview:containerView];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void) SelectedSegment: (UISegmentedControl *)control{
    //change views of the container view
    
    
    if (self.activeView) {
        [self.activeView viewWillDisappear:NO];
        //[self.containerView bringSubviewToFront:activeView.view];
        //[self.activeView.view removeFromSuperview];
        [self.activeView.view performSelectorOnMainThread:@selector(removeFromSuperview) withObject:nil waitUntilDone:NO];
        [self.activeView viewDidDisappear:NO];
        activeView = Nil;
        
    }
   
    if (control.selectedSegmentIndex == 0) {
        NoteViewController* noteViewCtrl = [[NoteViewController alloc] init];
        activeView = noteViewCtrl;
        noteViewCtrl = Nil;
    }else if(control.selectedSegmentIndex == 1){
        DocumentViewController* docViewCtrl = [[DocumentViewController alloc] init];
        activeView = docViewCtrl;
        docViewCtrl = Nil;
    }
    else if(control.selectedSegmentIndex == 2){
        QuestionViewController* quesViewCtrl = [[QuestionViewController alloc] init];
        quesViewCtrl.currUser = self.currUser;
        quesViewCtrl.selCourse = self.selCourse;
        //[self.navigationController pushViewController:quesViewCtrl animated:YES];
        activeView = quesViewCtrl;
        quesViewCtrl = Nil;
        quesViewCtrl.view.setNeedsDisplay;
    }
    else if(control.selectedSegmentIndex == 3){
        LiveDiscussionViewController* liveViewCtrl = [[LiveDiscussionViewController alloc] init];
        activeView = liveViewCtrl;
        liveViewCtrl = Nil;
    }
    
    [self.activeView viewWillAppear:NO];
    [containerView addSubview:activeView.view];
    [self.activeView viewDidAppear:NO];
    
    
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
