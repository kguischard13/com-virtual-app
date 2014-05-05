//
//  NoteViewController.h
//  classroom
//
//  Created by Christopher Forehand on 4/10/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Enums.h"

@interface NoteViewController : UIViewController <UITextFieldDelegate, UINavigationControllerDelegate>
{
	
    UIButton *btnSave, *btnEdit, *btnExport, *btnViewSlides;
    UIImageView *imgNoteViewer;
}

@property(nonatomic, retain) UIButton *btnSave, *btnEdit, *btnExport, *btnViewSlides;
@property(nonatomic, retain) UIImageView *imgNoteViewer;

@end
