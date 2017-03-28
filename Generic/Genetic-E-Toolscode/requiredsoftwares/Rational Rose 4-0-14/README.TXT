
Thank you for using Rational Rose version 4.0.14.  This release is
an upgrade to Rose 4.0.5.  The release includes fixes for the following
defects.

111166  If classes are contained in read-only categories, the 
        documentation field of the specification dialog can not
        be scrolled.

115168  After copy and paste in scenario diagrams, the data flow 
        icons sequence numbers can be changed to 0.

121366  Auto resize of class icons does not always work.

119411  The length diagram names is limited to 27 characters.  This
        has now been changed to 255.

122999  Modified and write status of controlled units is modified
        upon loading.

123213  Operation Name Size To Small When Pasting Message.  This has
        been fixed, however, in models that were written with previous
        versions of Rose have the shorter label length stored.  To
        correct these models, select all items on the diagram that shows
        clipped labels and then select the menu option Tools->Autosize All.

124111  CR/LF sometimes replaced with "|" in item documentation.

124889  During model load, dialogs with messages of the form: "Resolved to ..."
        is raised.  This causes the model load to stop until the OK button is 
        pressed.  These messages are now placed in the log.

124915  Selecting a tab in the operations specification can cause keyboard 
        edits of the return type to be lost.

124917  Attempting to delete an operation can cause error:"XXX Symbol Undefined".

124890  A busy cursor is now displayed during model and category loading.

124918  Browser window not updated after copying and paste.

124043  Open File/URL fails with read only controlled unit.

124088 (125679)  Crash on Message Trace diagrams when receiver class is read-only.

121586 The model and category files for a loaded model need to be writable in order
       to generate report.

126834 Check model executed during model load.

123806 Crash when loading mdl file containing object references to unnamed classes.

122634 Cannot invoke "File:Units:Load" after zoom-in or zoom-out have been used.
