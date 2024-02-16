import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  //Navigate to JLR website
  await page.goto('https://www.jaguarlandrover.com/');
  await page.screenshot({ path: 'JLRHomePage.png' });

  await expect(page.locator('.corp-header__logo')).toBeVisible();
  await expect(page.getByRole('img', { name: 'The royal warrants—by' })).toBeVisible();

  //Validate JLR Website Footer Section
  await expect(page.getByRole('contentinfo')).toContainText('REGISTERED OFFICE: ABBEY ROAD, WHITLEY, COVENTRY, CV3 4LF. REGISTERED IN ENGLAND NO: 6477691');
  await expect(page.getByText('JAGUAR LAND ROVER AUTOMOTIVE')).toBeVisible();
  await expect(page.getByRole('link', { name: 'News', exact: true })).toBeVisible();

  //Validate the JLR Hamburger Menu item navigation with partial expected URL's
  await page.waitForLoadState('load');
  await page.getByRole('link', { name: 'Company' }).click();
  await expect(page).toHaveURL(/overview/);
  await page.getByRole('link', { name: 'BRANDS & SERVICES' }).click();
  await expect(page).toHaveURL(/our-brands/);
  await page.getByRole('link', { name: 'Innovation' }).first().click();
  await expect(page).toHaveURL(/innovation/);
  await page.getByRole('link', { name: 'People' }).click();
  await page.getByRole('link', { name: 'Responsibility' }).click();
  await expect(page).toHaveURL(/corporate-responsibility/);
  await page.getByRole('link', { name: 'Investor Relations' }).click();
  await expect(page).toHaveURL(/investor-relations/);
  await page.getByRole('link', { name: 'NEWS & MEDIA' }).click();
  await expect(page).toHaveURL(/en/);
  await page.getByRole('link', { name: 'Corporate Logo' }).first();

  //Validate the JLR-Website News Sections item's
  await expect(page.getByRole('img', { name: 'reimagine hero image' })).toBeVisible();
  await expect(page.locator('h1')).toContainText('is our roadmap for the future');
  await expect(page.locator('section')).toContainText('LEARN MORE');
  await expect(page.locator('section')).toContainText('Latest News');
  await expect(page.locator('#focusedImage')).toBeVisible();
  await expect(page.getByRole('link', { name: 'JLR PROFITABILITY CONTINUES' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'JLR Executive Board' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'JLR DELIVERS SIGNIFICANTLY' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'JLR TRAINS HUNDREDS IN NEW' })).toBeVisible();

  
});